# Clojurebook

An interactive web application with Compojure and Ring. Users will have the ability to register an account, login with their credentials, store pictures along with descriptions of the picture as well as browse other users' galleries and communicate with each through a real-time chat service. Also, users will have access to weather data (such as temperature and wind) in their respective area. Another feature will be posting comments to peoples' galleries. Finally, users will have the ability to close their account and delete all of the data associated with it. 

Ideally, private messaging will be enabled at a later stage of the application where users will be able to contact each other even if direct, real time messaging is unavailable, i.e. there are no other users online.

## Goals of the project 

- [x] **1. Register an Account**
 * collect user ID's and passwords and store them in a database
 * validate credentials upon logging in

- [x] **2. Login and Logout**
 * allow users to log in and out
 * display a welcome message when a user is not in session
 * when the user is in session, a logout button will be displayed

- [x] **3. Upload Photos**
 * provide users with the ability to add pictures 
 * a thumbnail will be used as a link to a full-sized picture
 * add a picture timestamp
 * list user galleries

- [x] **4. Include Photo Descriptions**
 * allow users to include descriptions of the pictures they have uploaded

- [x] **5. Delete Photos and Descriptions**
 * provide an interface for users to remove their uploads 
 * the interface should delete all data stored for a particular user

**6. Comment on Photos**
- [ ] allow user to comment on photos, both their own and of others
- [ ] allow user to delete comments posted by... 
   - [ ] that user on any photo
   - [ ] other users who have commented on that user's photos

**7. Display Weather Data**
- [ ] possible options include [OpenWeatherMap's API] (http://openweathermap.org/) and [The Weather Channel's API](http://www.wunderground.com/weather/api/?ref=twc), [among others](http://www.programmableweb.com/news/top-10-weather-apis/analysis/2014/11/13) 
- [ ] use geolocation to display weather data at the user's login location
- [ ] although many map layers are available, this project will focus solely on temperature and wind data  
 
**8. Implement a real-time chat service**
- [ ] viable options include [Aleph](https://github.com/ztellman/aleph), an asynchronous, Ring-compliant library for client and server network programming, [asynch-sockets](https://github.com/bguthrie/async-sockets), [clj-sockets](https://github.com/atroche/clj-sockets) as well as [other websocket interfaces](https://clojars.org/search?q=websockets)
 
- [x] **9. Delete Account**
 *  when an account is deleted, the user and all of their corresponding data are removed from the database
 
- [ ] **10. Deploy on Heroku**

## Prerequisites

You will need [PostgreSQL](http://www.postgresql.org/) 9.1 or above and [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen 

## Running

To start a web server for the application, run:

    lein ring server

## Resources

This project is inspired by [*Web Development with Clojure*] (https://pragprog.com/book/dswdcloj/web-development-with-clojure) by [Dmitri Sotnikov](https://github.com/yogthos).

## License

The MIT License (MIT)

Copyright © 2016 Atanas S. Apostolov 
