# Clojurebook

An interactive web application with Compojure and Ring. Users will have the ability to register an account, login with their credentials, store pictures along with descriptions of the picture as well as browse other users' galleries and communicate with each through a real-time chat service. Also, users will have access to weather data (such as temperature and wind) in their respective area. Finally, users will have the ability to close their account and delete all of the data associated with it. 

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
- [x] a thumbnail will be used as a link to a full-sized picture
- [ ] add a picture timestamp
- [x] list user galleries

**4. Include Photo Descriptions**
- [ ] allow users to include descriptions of the pictures they have uploaded
- [ ] add a description timestamp 

**5. Delete Photos and Descriptions**
- [x] provide an interface for users to remove their uploads 
- [x] the interface should delete all data stored for a particular user

**6. Display Weather Data**
- [ ] possible options include [OpenWeatherMap's API] (http://openweathermap.org/) and [The Weather Channel's API](http://www.wunderground.com/weather/api/?ref=twc), [among others](http://www.programmableweb.com/news/top-10-weather-apis/analysis/2014/11/13) 
- [ ] use geolocation to display weather data at the user's login location
- [ ] although many map layers are available, this project will focus solely on temperature and wind data  
 
**7. Implement a real-time chat service**
- [ ] viable options include [Aleph](https://github.com/ztellman/aleph), an asynchronous, Ring-compliant library for client and server network programming, [asynch-sockets](https://github.com/bguthrie/async-sockets), [clj-sockets](https://github.com/atroche/clj-sockets) as well as [other websocket interfaces](https://clojars.org/search?q=websockets)
 
- [x] **8. Delete Account**
 *  when an account is deleted, the user and all of their corresponding data are removed from the database
 
- [ ] **9. Deploy on Heroku**

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## Resources

This project is inspired by [*Web Development with Clojure*] (https://pragprog.com/book/dswdcloj/web-development-with-clojure) by [Dmitri Sotnikov](https://github.com/yogthos).

## License

Copyright © 2016 FIXME
