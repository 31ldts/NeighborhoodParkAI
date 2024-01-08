# NeighborhoodParkAI
Our initiative focuses on leveraging artificial intelligence to determine the optimal locations of green spaces in neighborhoods. Our goal is to identify the most suitable places for parks, ensuring maximum accessibility for residents, considering factors such as proximity and the optimal use of resources.

The project has been built in Java, using the IDE NetBeans. Using the clone option of NetBeans should be possible to setup the program. If not, cloning the repository and opening the project in netbeans should work just fine. All the files are in the branch "Master".

In this project we use a system of "Controllers". Due to Genetic Algorithms having very distinct parts (Inicializer, Mutation, Crossover, Selection, fitness...) and because we wanted to implement more than one class for each one, we use controllers to decide what class we use and how we use it, even if we mix classes (use two types of mutations).

Inside the folder "src" there are the source files of the porject, splited in the packages "Basic", "Model" and "Views".
    
    -Basic: This package just contains the class Position and a sort class for it.
  
    -Model: This package contains all the important files of the project, splited in sub-packages. Outside the subpackages there are the parammeters class and the "ParkInCityGA" file, that executes the Genetic Algorithm.
    
    -Individuals: Contains all the necessary files to codify an individual: 
                    Tiles(ParkTile,BuildingTile...), being the smallest part of a city; 
                    CityTileset, The individual itself, a 2D array of Tiles, with the necessary methods to operate with them; 
                    Neighborhood, a portion of a city that helps to make local operations on CityTileset;                                     
                    CityTilesetPopulation, a fixed size population of CityTileset;
                    And finally the abstract classes for individual, population, fixed size (all three done by our Profesor Fabio Palomba) population and Tile
    
    -Inicializer: Contains the inizializers of the individuals. The two main inicializers are for the city itself (roads and buildings), and for the parks. There is also another class called CloseToBuildingParkInizialicer, that would implement an heuristic to inicialize the ParkTiles near buildings or even near high density buildings, but due to bad planification and time issues, this class is not implemented
    
    -Operators: Contains the three main operators of a Genetic Algorithm as sub-packages: Selection, Mutation and Crossover
      
      -Selection: We have implemented two algorithms to make the selection of individuals (KWayTournamentSelection was not implemented due to planing problems):
                    RankSelection gives a rank to each of the individual in a population according to its fitness, and then adds the each individual with a probbility associated to its
 rank. Then repeats until the next generation has as much individuals as the previous.
                    NaturalSelection created a mating pool and adds copies of the individuals according to its fitness. Then picks ftom the mating pool individuals until the next generation is full.
      
      -Corssover: Contains two different crossovers (GeometricalCrossover was not implemented due to planing problems). We use the class CrossoverOperator (done by our profesor Fabio Palomba) mostly to create the pairs of parents.
                    NeighborhoodCrossover chooses randomly a neighborhood of the parent cities (a nxn sub-tileset of a city), and exchanges the parks between them.
                    TilesCrossover chooses random parks from both parents and exchanges them
      
      -Mutation: Contains the mutations of the algorithm
                  ParkExpansion mutation creates and removes HOLE PARKS, in the sense of ParkTiles one next to another.
                  PointNeighborhoodMutation choose a neighborhood and remove or expand its parkTiles
                  RandomParkMutation remove or expand random ParkTiles
                  TargetedNeighborhoodMutation chooses the neighborhoods with most parks and remove or expand its parks.
  -Views: This package is charge of the interface of the program. It is divided in a StartWindows, that let the user change some parammeters of the algorithm and start the program; and the main window, thatshows the cities of the last generation. However, for a more detailed view of the results, we give the fitness of each city and the best individual for 10 generations in the text output.

