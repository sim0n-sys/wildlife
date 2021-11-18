## wildlife

Wildlife Tracker is an app that allows one to records of various animal,It allows one to create rangers,locations and animals . It also allows you to view rangers locations, and animals. Using this fetures the application helps to track and moniter animals in there enviroment.  



## ATHOR
Simon Mungai Njoroge- This project was completed as part of Code Moringa Mentored Online Full Stack Web Development course in 2021.

## Technologies Used
Technologies used are as follows
* HTML5 
* CSS
* java 
* Handlebars

## Setup/Installation Requirements
* Fork this repo
* Clone this repo
* Open terminal
* Navigate to appropriate directory using the cd command
  type in the command git clone and paste the url of clone and then press enter

## Database.
* CREATE DATABASE wildlife_tracker;
* \c wildlife_tracker
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar,type VARCHAR,health VARCHAR,age VARCHAR);
* CREATE TABLE locations (id serial PRIMARY KEY,name VARCHAR);
* CREATE TABLE rangers (id serial PRIMARY KEY,name VARCHAR,badge_number VARCHAR);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;


## contact details
* Email Simonalexno@gmail.com.

### License
Copyright SIMON MUNGAI 2021

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge,publish,distribute, sublicense, and/or sell
copies of the Software,and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
