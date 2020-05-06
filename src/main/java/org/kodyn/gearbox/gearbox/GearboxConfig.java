package org.kodyn.gearbox.gearbox;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

public class GearboxConfig {
    @Getter
    private final int maxGear;
    @Getter
    private final int currentGear;
    @Getter
    private final GearboxState state;
    @Getter
    private final GearboxMode mode;
    @Getter
    private final boolean dynamicMode;

    public GearboxConfig(@Value("${gearbox.maxGear}") int maxGear,@Value("${gearbox.currentGear}") int currentGear, @Value("${gearbox.state}") GearboxState state, @Value("${gearbox.mode}") GearboxMode mode, @Value("${gearbox.dynamicMode}") boolean dynamicMode) {
        if (currentGear < 1 || currentGear > maxGear) {
            throw new IllegalArgumentException();
        }
        this.maxGear = maxGear;
        this.currentGear = currentGear;
        this.state = state;
        this.mode = mode;
        this.dynamicMode = dynamicMode;
    }
}
