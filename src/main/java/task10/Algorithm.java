package task10;

import java.util.*;

public class Algorithm {

    public Map<String, Integer> algorithm(String city, Map<String, Set<Neighbor>> map){

        Map<String, Boolean> cityWasVisitOrNo = new HashMap<>();
        map.forEach((str, set) -> cityWasVisitOrNo.put(str, false));

        PriorityQueue<Neighbor> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Neighbor::getDistance));
        priorityQueue.addAll(map.get(city));

        Map<String, Integer> bestDistances = new HashMap<>();
        map.forEach((str, set) -> bestDistances.put(str, null));
        bestDistances.replace(city, 0);

        String currentCity = city;

        while(true){
            for (Neighbor neighbor : priorityQueue){
                if (cityWasVisitOrNo.get(neighbor.city))
                    continue;

                if (bestDistances.get(neighbor.city) == null){
                    bestDistances.put(neighbor.city, neighbor.distance + bestDistances.get(currentCity));
                    continue;
                }

                if (bestDistances.get(neighbor.city) > bestDistances.get(currentCity) + neighbor.distance){
                    bestDistances.put(neighbor.city, neighbor.distance + bestDistances.get(currentCity));
                }
            }

            cityWasVisitOrNo.put(currentCity, true);

            if (!cityWasVisitOrNo.containsValue(false))
                break;

            while (cityWasVisitOrNo.get(currentCity)){
                currentCity = priorityQueue.remove().city;
            }
            priorityQueue.clear();
            priorityQueue.addAll(map.get(currentCity));
        }
        return bestDistances;
    }
}
