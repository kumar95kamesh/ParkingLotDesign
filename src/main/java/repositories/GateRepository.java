package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gateIdToGateMap = new HashMap<>();

    public GateRepository(){
        Gate gate = new Gate();
        gate.setId(20);

        gateIdToGateMap.put(20L, gate);
    }

    public Optional<Gate> findGateById(Long id){
        if(gateIdToGateMap.containsKey(id)){
            return Optional.of(gateIdToGateMap.get(id));
        }else{
            return Optional.empty();
        }
    }
}
