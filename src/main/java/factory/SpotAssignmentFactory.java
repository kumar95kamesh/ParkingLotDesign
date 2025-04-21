package factory;

import models.enums.SpotAssignmentStrategyType;
import strategies.CheapestSpotAssignmentStrategy;
import strategies.NearestSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy;

public class SpotAssignmentFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType){
        if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)){
            return new CheapestSpotAssignmentStrategy();
        }else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.NEAREST)){
            return new NearestSpotAssignmentStrategy();
        }else{
            return null;
        }
    }
}
