package net.pinger.uhc.scenarios;

import com.google.common.collect.Sets;
import net.pinger.uhc.AdvancedUHC;
import net.pinger.uhc.scenarios.types.CutClean;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ScenarioManager {

    private final AdvancedUHC advancedUHC;
    private final Set<Scenario> holder = Sets.newHashSet();

    public ScenarioManager(AdvancedUHC advancedUHC) {
        this.advancedUHC = advancedUHC;

        this.holder.add(new CutClean(this.advancedUHC));
    }

    public Collection<? extends Scenario> getEnabledScenarios() {
        return this.holder.stream().filter(Scenario::isEnabled).collect(Collectors.toList());
    }

    public Collection<? extends Scenario> getDisabledScenarios() {
        return this.holder.stream().filter(scenario -> !scenario.isEnabled()).collect(Collectors.toList());
    }

    public Collection<? extends Scenario> getScenarios() {
        return this.holder;
    }
}
