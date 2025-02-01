## Design a Parking Lot 

A parking lot or car park is a dedicated cleared area that is intended for parking vehicles. In most countries where cars are a major mode of transportation, parking lots are a feature of every city and suburban area. Shopping malls, sports stadiums, megachurches, and similar venues often feature parking lots over large areas.

### Requirements

How many Entrances?
- 1 Entrance
- 1 Exit
- Different type of parking spots:
- 2 Wheeler
- 4 Wheeler
- Payment: Hourly / Minute based charge => Mix
- Floors? => No

Objects:

- Vehicle
  1 Vehicle No.
  2 Vehicle Type (Enum)
- Ticket
    1. Entry Time
    2. Parking Spot
- Entrance Gate
    1. Find Parking Space (Nearest Parking to the entrance)
    2. Update Parking space
    3. Generate Ticket
- Parking Spot
    1. id
    2. isEmpty
    3. Vehicle
    4. Price
    5. Type
- Exit Gate
    1. Cost Calculation
    2. Payment
    3. Update Parking Spot

````+------------------+
|      Vehicle     |
+------------------+
| - vehicleNo: String
| - type: VehicleType
+------------------+

+------------------+
|     Ticket       |
+------------------+
| - ticketId: String
| - entryTime: DateTime
| - parkingSpot: ParkingSpot
| - vehicle: Vehicle
+------------------+

+------------------+
|  ParkingSpot     |
+------------------+
| - id: String
| - isEmpty: Boolean
| - vehicle: Vehicle
| - price: Double
| - type: ParkingSpotType
+------------------+
| + assignVehicle(vehicle: Vehicle): void
| + removeVehicle(): void
+------------------+

+------------------+
| EntranceGate     |
+------------------+
| - id: String
| - parkingSpots: List<ParkingSpot>
+------------------+
| + findNearestSpot(type: ParkingSpotType): ParkingSpot
| + generateTicket(vehicle: Vehicle): Ticket
+------------------+

+------------------+
| ExitGate         |
+------------------+
| - id: String
| + calculateCost(ticket: Ticket, exitTime: DateTime): Double
| + processPayment(ticket: Ticket, amount: Double): void
| + vacateParkingSpot(ticket: Ticket): void
+------------------+

+------------------+
| ParkingLot       |
+------------------+
| - entranceGate: EntranceGate
| - exitGate: ExitGate
| - parkingSpots: List<ParkingSpot>
+------------------+
| + getAvailableSpots(): List<ParkingSpot>
| + initializeParkingLot(spots: List<ParkingSpot>): void
+------------------+
````