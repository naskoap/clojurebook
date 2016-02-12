# Clojurebook

An interactive web application with Compojure and Ring

## Goals of the project 

- [x] **1. Register an Account**
 * collect user ID's and passwords and store them in a database
 * validate credentials upon logging in

- [x] **2. Login and Logout**
 * allow users to log in and out
 * display a welcome message when a user is not in session
 * when the user is in session, a logout button will be displayed

**3. Upload Photos**
- [x] provide users with the ability to add pictures 
- [ ] a thumbnail will be used as a link to a full-sized picture
- [ ] add a picture timestamp
- [ ] list user galleries

**4. Include Photo Descriptions**
- [ ] allow users to include descriptions of the pictures they have uploaded
- [ ] add a description timestamp 

**5. Delete Photos and Descriptions**
- [ ] provide an interface for users to remove their uploads 
- [ ] the interface should delete all three components: the picture, its thumbnail and its description

**6. Display Weather Data**
- [ ] use [OpenWeatherMap's API] (http://openweathermap.org/) and geolocation to display weather data at the location where the user is logging in from
- [ ] although many map layers are available, this project will focus solely on temperature and wind data  
 
**7. Implement a real-time chat service with [Aleph](https://github.com/ztellman/aleph)**
- [ ] Aleph is Ring-compliant and offers full peformance and flexibility 
 
**8. Delete Account**
- [ ] when an account is deleted, the user and all of their corresponding data are removed from the database

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## Resources

This project is based on an exercise featured in [*Web Development with Clojure*] (https://pragprog.com/book/dswdcloj/web-development-with-clojure) by [Dmitri Sotnikov](https://github.com/yogthos).

## License

Copyright © 2016 FIXME
