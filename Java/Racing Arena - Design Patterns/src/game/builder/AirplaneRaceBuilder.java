
package game.builder;

import factory.ArenaFactory;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.air.Airplane;
import game.racers.prototype.PrototypeFactory;

public class AirplaneRaceBuilder extends RaceBuilder {
	

	private int numOfRacers;

	public AirplaneRaceBuilder(int numOfRacers) {
		this.numOfRacers = numOfRacers;
	}

	@Override
	void buildArena() {
		race.setArena(ArenaFactory.createArenaByScpeciality("Air"));
	}

	@Override
	void buildRacers() throws RacerLimitException, RacerTypeException {

		if (numOfRacers > race.getArena().getMaxRacers()) {
			throw new RacerLimitException("Number of racers that you want to add is bigger than maximum racers in arena");

		} else {

			Racer racer = new Airplane(); // Prototype 
			PrototypeFactory factory = new PrototypeFactory(racer);
			race.getArena().addRacer(racer);

			for (int i = 1; i <= numOfRacers; i++) {
				Racer racerClone = factory.cloneRacer();
				race.getArena().addRacer(racerClone);
			}

		}
	}

}
