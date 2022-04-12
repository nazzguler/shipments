# shipments
base suitability score (SS) of destinations for drivers

1. The application calculates the base maximized suitable destination for drivers looping the driver list where the conditions for each driver are validated.
2. Once a driver has been assinged with a destination, the destiation gets removed from the list as there is a one to one relationship (each driver should have only one destination)
and the loop continues. This guarantess none of the drivers will get a duplicated destination
3. During this loop, a map data structure is filled up with the final assignment (driver-destination) so when the driver is clicked on the list, we can get its corresponding
destination from the map
4. Created extend functions to calculate common factos and constant counts 
