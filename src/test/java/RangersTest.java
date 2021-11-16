import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangersTest {

    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();

    @Test
    public void createInstanceOfRangersClass_true(){
        Rangers ranger= setUpNewRanger();
        assertEquals(true,ranger instanceof Rangers);
    }

//    @Test
//    public void allEntriesAreSaved() {
//        Rangers ranger= setUpNewRanger();
//        ranger.save();
//        assertTrue(Rangers.all().get(0).equals(ranger));
//
//    }

    @Test
    public void emptyFieldsAreNotSaved() {
        Rangers ranger=new Rangers("","","");
        try{
            ranger.save();
            assertTrue(Rangers.all().get(0).equals(ranger));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

//    @Test
//    public void findById() {
//        Rangers ranger= setUpNewRanger();
//        Rangers otherRanger=new Rangers("Daniel","2","0762336267");
//        ranger.save();
//        otherRanger.save();
//        Rangers foundRanger=Rangers.find(ranger.getId());
//        assertTrue(foundRanger.equals(ranger));
//
//    }

//    @Test
//    public void entryIsUpdatedCorrectly() {
//        Rangers ranger= setUpNewRanger();
//        Rangers otherRanger=ranger;
//        ranger.save();
//        try {
//            ranger.update(ranger.getId(),"simon","0714780833");
//            Rangers foundRanger=Rangers.find(ranger.getId());
//            assertNotEquals(foundRanger,otherRanger);
//            assertEquals(foundRanger.getId(),otherRanger.getId());
//
//        }catch (IllegalArgumentException e){
//            System.out.println(e);
//        }
//    }

//    @Test
//    public void entriesAreDeleted() {
//        Rangers ranger= setUpNewRanger();
//        Rangers otherRanger=new Rangers("Daniel","2","0762336267");
//        ranger.save();
//        otherRanger.save();
//        ranger.delete();
//        assertEquals(null,Rangers.find(ranger.getId()));
//
//    }



    private Rangers setUpNewRanger() {
        return new Rangers("Simom","1","0714780833");
    }

}