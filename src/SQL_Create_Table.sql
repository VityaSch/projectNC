CREATE TABLE Genres(
  genre_id INT NOT NULL PRIMARY KEY,
  name VARCHAR2(50) NOT NULL
  );

CREATE TABLE Movies(
  movie_id INT NOT NULL PRIMARY KEY,
  name VARCHAR2(50) NOT NULL,
  director VARCHAR2(20) NOT NULL,
  short_description VARCHAR2(50) NOT NULL,
  description VARCHAR2(100) NOT NULL,
  year_release DATE NOT NULL,
  lenght DATE NOT NULL
  );

CREATE TABLE Movies_genres(
  movie_id INT NOT NULL,
  genre_id INT NOT NULL,
  FOREIGN KEY (movie_id) REFERENCES Movies(movie_id),
  FOREIGN KEY (genre_id) REFERENCES Genres(genre_id)
  );

CREATE TABLE News(
  news_id INT NOT NULL PRIMARY KEY,
  movie_id INT NOT NULL,
  name VARCHAR2(50) NOT NULL,
  description VARCHAR2(100) NOT NULL,
  date_time DATE NOT NULL,
  FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)
  );

CREATE TABLE Events(
  event_id INT NOT NULL PRIMARY KEY,
  name VARCHAR2(50) NOT NULL,
  description VARCHAR2(100) NOT NULL,
  date_time_new DATE NOT NULL,
  date_tine_end DATE NOT NULL,
  discount INT NOT NULL
  );

CREATE TABLE Movies_events(
  evetn_id INT NOT NULL,
  movie_id INT NOT NULL,
  FOREIGN KEY (evetn_id) REFERENCES Events(event_id),
  FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)
  );

CREATE TABLE Halls(
  hall_id INT NOT NULL PRIMARY KEY,
  count_place INT NOT NULL,
  count_row INT NOT NULL
  );

CREATE TABLE Places(
  place_id INT NOT NULL PRIMARY KEY,
  hall_id INT NOT NULL,
  "row" INT NOT NULL,
  number_place INT NOT NULL,
  FOREIGN KEY (hall_id) REFERENCES Halls(hall_id)
  );

CREATE TABLE Sessions(
  session_id INT NOT NULL PRIMARY KEY,
  movie_id INT NOT NULL,
  hall_id INT NOT NULL,
  date_time DATE NOT NULL,
  FOREIGN KEY (movie_id) REFERENCES Movies(movie_id),
  FOREIGN KEY (hall_id) REFERENCES Halls(hall_id)
  );

CREATE TABLE Tickets(
  ticket_id INT NOT NULL PRIMARY KEY,
  session_id INT NOT NULL,
  place_id INT NOT NULL,
  date_time DATE NOT NULL,
  price INT NOT NULL,
  FOREIGN KEY (session_id) REFERENCES Sessions(session_id),
  FOREIGN KEY (place_id) REFERENCES Places(place_id)
  );

CREATE TABLE Sales(
  sale_id INT NOT NULL PRIMARY KEY,
  ticket_id INT NOT NULL,
  "date" DATE NOT NULL,
  price INT NOT NULL,
  FOREIGN KEY (ticket_id) REFERENCES Tickets(ticket_id)
  );

CREATE TABLE Bookings(
  booking_id INT NOT NULL PRIMARY KEY,
  session_id INT NOT NULL,
  surname VARCHAR2(50) NOT NULL,
  name VARCHAR2(20) NOT NULL,
  FOREIGN KEY (session_id) REFERENCES Sessions(session_id)
  );

CREATE TABLE Places_bookings(
  booking_id INT NOT NULL,
  place_id INT NOT NULL,
  FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id),
  FOREIGN KEY (place_id) REFERENCES Places(place_id)
  );