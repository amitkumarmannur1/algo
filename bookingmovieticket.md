classDiagram
direction BT
class Actor {
  + Actor() 
  - List~Movie~ movies
  - String name
   String name
   List~Movie~ movies
}
class Auditorium {
  + Auditorium() 
  - String name
  - List~Seat~ seats
  - int capacity
  - Theatre theatre
  - List~AuditoriumFeature~ auditoriumFeatures
   String name
   List~AuditoriumFeature~ auditoriumFeatures
   int capacity
   List~Seat~ seats
   Theatre theatre
}
class AuditoriumFeature {
<<enumeration>>
  + AuditoriumFeature() 
  + values() AuditoriumFeature[]
  + valueOf(String) AuditoriumFeature
}
class AuditoriumRepository {
<<Interface>>

}
class BaseModel {
  + BaseModel() 
  - Long id
   Long id
}
class BookMyShowApplication {
  + BookMyShowApplication(UserController, CityController, TheatreController, ShowController, TicketController) 
  + run(String[]) void
  + main(String[]) void
}
class BookMyShowApplicationTests {
  + BookMyShowApplicationTests() 
  ~ contextLoads() void
}
class City {
  + City() 
  - String name
  - List~Theatre~ theatres
   String name
   List~Theatre~ theatres
}
class CityController {
  + CityController(CityService) 
  + addCity(String) City
}
class CityNotFoundException {
  + CityNotFoundException(String) 
}
class CityRepository {
<<Interface>>
  + findById(Long) Optional~City~
  + save(City) City
  + findAllByName(String) List~City~
}
class CityService {
  + CityService(CityRepository) 
  + addCity(String) City
}
class CreateUserRequestDto {
  + CreateUserRequestDto() 
  - String email
   String email
}
class CreateUserResponseDto {
  + CreateUserResponseDto() 
  - User user
   User user
}
class Language {
<<enumeration>>
  + Language() 
  + values() Language[]
  + valueOf(String) Language
}
class Movie {
  + Movie() 
  - String name
   String name
   List~Actor~ casts
}
class MovieFeature {
<<enumeration>>
  + MovieFeature() 
  + values() MovieFeature[]
  + valueOf(String) MovieFeature
}
class Payment {
  + Payment() 
  - PaymentMethod paymentMethod
  - Date timeOfPayment
  - double amount
  - String referenceId
  - Ticket ticket
  - PaymentStatus paymentStatus
   Date timeOfPayment
   PaymentMethod paymentMethod
   PaymentStatus paymentStatus
   Ticket ticket
   double amount
   String referenceId
}
class PaymentMethod {
<<enumeration>>
  + PaymentMethod() 
  + valueOf(String) PaymentMethod
  + values() PaymentMethod[]
}
class PaymentStatus {
<<enumeration>>
  + PaymentStatus() 
  + valueOf(String) PaymentStatus
  + values() PaymentStatus[]
}
class ScreenType {
<<enumeration>>
  + ScreenType() 
  + values() ScreenType[]
  + valueOf(String) ScreenType
}
class Seat {
  + Seat() 
  - SeatType seatType
  - String seatNumber
   String seatNumber
   SeatType seatType
}
class SeatRepository {
<<Interface>>

}
class SeatType {
<<enumeration>>
  + SeatType() 
  + valueOf(String) SeatType
  + values() SeatType[]
}
class Show {
  + Show() 
  - Movie movie
  - List~ShowSeatType~ showSeatTypes
  - List~ShowSeat~ showSeats
  - Date endTime
  - Auditorium auditorium
  - Date startTime
  - Language language
  - List~ShowFeature~ showFeatures
   Date startTime
   Movie movie
   Auditorium auditorium
   List~ShowSeatType~ showSeatTypes
   List~ShowSeat~ showSeats
   Language language
   Date endTime
   List~ShowFeature~ showFeatures
}
class ShowController {
  + ShowController(ShowService) 
  + createShow(Long, Date, Date, Long, Map~SeatType, Integer~, Language) Show
}
class ShowFeature {
<<enumeration>>
  + ShowFeature() 
  + valueOf(String) ShowFeature
  + values() ShowFeature[]
}
class ShowRepository {
<<Interface>>
  + findById(Long) Optional~Show~
}
class ShowSeat {
  + ShowSeat() 
  - ShowSeatState state
  - Show show
  - Seat seat
   Show show
   ShowSeatState state
   Seat seat
}
class ShowSeatNotAvailableException {
  + ShowSeatNotAvailableException(String) 
}
class ShowSeatRepository {
<<Interface>>
  + findByIdIn(List~Long~) List~ShowSeat~
  + save(ShowSeat) ShowSeat
}
class ShowSeatState {
<<enumeration>>
  + ShowSeatState() 
  + values() ShowSeatState[]
  + valueOf(String) ShowSeatState
}
class ShowSeatType {
  + ShowSeatType() 
  - SeatType seatType
  - double price
  - Show show
   Show show
   double price
   SeatType seatType
}
class ShowService {
  + ShowService(AuditoriumRepository, ShowRepository, ShowSeatRepository) 
  + createShow(Long, Date, Date, Long, Map~SeatType, Integer~, Language) Show
}
class Theatre {
  + Theatre() 
  - List~Auditorium~ auditoriums
  - String address
  - String name
  - List~Show~ upcomingShows
   List~Auditorium~ auditoriums
   String name
   String address
   List~Show~ upcomingShows
}
class TheatreController {
  + TheatreController(TheatreService) 
  + createTheatre(String, String, Long) Theatre
  + addSeats(Long, Map~SeatType, Integer~) void
  + addAuditorium(Long, String, int) Theatre
}
class TheatreRepository {
<<Interface>>
  + save(Theatre) Theatre
}
class TheatreService {
  + TheatreService(TheatreRepository, CityRepository, AuditoriumRepository, SeatRepository) 
  + addAuditorium(Long, String, int) Theatre
  + createTheatre(String, String, Long) Theatre
  + addSeats(Long, Map~SeatType, Integer~) void
}
class Ticket {
  + Ticket() 
  - Show show
  - Date timeOfBooking
  - User bookedBy
  - double totalAmount
  - List~ShowSeat~ showSeats
  - TicketStatus ticketStatus
   Date timeOfBooking
   TicketStatus ticketStatus
   double totalAmount
   User bookedBy
   List~ShowSeat~ showSeats
   Show show
   TicketStatus bookingStatus
}
class TicketBookRunner {
  + TicketBookRunner(TicketController, Long, List~Long~, Long) 
  + run() void
}
class TicketController {
  + TicketController(TicketService) 
  + bookTicket(Long, List~Long~, Long) Ticket
}
class TicketService {
  + TicketService(ShowSeatRepository, UserRepository, ShowRepository) 
  + bookTicket(Long, List~Long~, Long) Ticket
}
class TicketStatus {
<<enumeration>>
  + TicketStatus() 
  + values() TicketStatus[]
  + valueOf(String) TicketStatus
}
class User {
  + User() 
  - String email
   String email
}
class UserController {
  + UserController(UserService) 
  + createUser(CreateUserRequestDto) CreateUserResponseDto
}
class UserRepository {
<<Interface>>
  + save(User) User
  + findById(Long) Optional~User~
}
class UserService {
  + UserService(UserRepository) 
  + createUser(String) User
}

Actor  -->  BaseModel 
Auditorium  -->  BaseModel 
City  -->  BaseModel 
Movie  -->  BaseModel 
Payment  -->  BaseModel 
Seat  -->  BaseModel 
Show  -->  BaseModel 
ShowSeat  -->  BaseModel 
ShowSeatType  -->  BaseModel 
Theatre  -->  BaseModel 
Ticket  -->  BaseModel 
User  -->  BaseModel 
