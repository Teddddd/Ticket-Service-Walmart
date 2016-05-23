Ticket Service

A simple ticket service Application for a discovery, temporary hold,
and final reservation of seats within a high-demand performance venue.
Some of the functionalities: 
 
- Find the number of seats available within the venue, optionally by seating level

- Find and hold the best available seats on behalf of a customer, potentially limited to specific levels
  (Each Ticket hold expires within 120 seconds)

- Reserve and commit a specific group of held seats for a customer


* Prerequisites:

Install the latest version of Java and Maven.

* Import the project in the Eclipse 

Go to -> File-> Import -> Maven -> Existing Maven Projects -> select TicketService Project

* Debug

Right-click on TicketService project
Debug As -> Java Application
Choose ->Main- com.walmart.tickerservice.presentation  

* Run

Right-click on TicketService project
Run As -> Java Application
Choose ->Main- com.walmart.tickerservice.presentation  

* Directory Structure

  -Presentation  (com.walmart.ticketservice.presentation)
       -Main.java

  -Service   (com.walmart.ticketservice.service)
       -TicketService.java
       -TicketServiceImpl

  -Data    (com.walmart.ticketservice.data)
       -AppSettings.java
       -DataAccess.Java
       -Seat.java
       -SeatHold.java
       -SeatHoldImpl
       -SeatImpl.java
       -SeatingArrangment.java
       -SeatingArrangmentImpl.java