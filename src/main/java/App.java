import org.apache.log4j.BasicConfigurator;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        BasicConfigurator.configure();

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());


        get("/create/ranger",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"ranger-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/create/ranger/new",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            String name=request.queryParams("name");
            String badge_number=request.queryParams("badge");
            String phone_number=request.queryParams("phone");
            Rangers ranger=new Rangers(name,badge_number,phone_number);
            ranger.save();
            return new ModelAndView(model,"ranger-form.hbs");
        },new HandlebarsTemplateEngine());
        get("/view/rangers",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("rangers",Rangers.all());
            return new ModelAndView(model,"ranger-view.hbs");
        },new HandlebarsTemplateEngine());
       





        get("/create/location",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"location-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/create/location/new",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            String name=request.queryParams("name");
            Locations location=new Locations(name);
            try {
                location.save();
            }catch (IllegalArgumentException e){
                System.out.println(e);
            }

            return new ModelAndView(model,"location-form.hbs");
        },new HandlebarsTemplateEngine());
        get("/view/locations",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("locations",Locations.all());
            return new ModelAndView(model,"location-view.hbs");
        },new HandlebarsTemplateEngine());



        get("/create/animal",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/create/animal/new",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            String type=request.queryParams("type");
            System.out.println(type);
            String health=request.queryParams("health");
            System.out.println(health);
            String age=request.queryParams("age");
            System.out.println(age);
            String name=request.queryParams("name");
            System.out.println(name);
            if(type.equals(EndangeredAnimals.ANIMAL_TYPE)){
                EndangeredAnimals endangered=new EndangeredAnimals(name,EndangeredAnimals.ANIMAL_TYPE,health,age);
                endangered.save();
            }
            else {
                Animals animal=new Animals(name,Animals.ANIMAL_TYPE);
                animal.save();
            }

            return new ModelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());

        get("/create/animal/endangered",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            List<String> health= new ArrayList<String>();
            health.add(EndangeredAnimals.HEALTH_HEALTHY);
            health.add(EndangeredAnimals.HEALTH_ILL);
            health.add(EndangeredAnimals.HEALTH_OKAY);
            List<String> age= new ArrayList<String>();
            age.add(EndangeredAnimals.AGE_ADULT);
            age.add(EndangeredAnimals.AGE_NEWBORN);
            age.add(EndangeredAnimals.AGE_YOUNG);
            model.put("health",health);
            model.put("age",age);
            String typeChosen="endangered";
            model.put("endangered",typeChosen);
            return new ModelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());

        get("/view/animals",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            model.put("animals",Animals.all());
            return new ModelAndView(model,"animal-view.hbs");
        },new HandlebarsTemplateEngine());







    }
}
