package net.pinger.uhc.scenarios;

import com.google.common.collect.Sets;
import net.pinger.uhc.AdvancedUHC;
import net.pinger.uhc.scenarios.types.CutClean;

import java.util.Set;

public class ScenarioManager {

    private final AdvancedUHC advancedUHC;
    private final Set<Scenario> holder = Sets.newHashSet();

    public ScenarioManager(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;
    }


}
