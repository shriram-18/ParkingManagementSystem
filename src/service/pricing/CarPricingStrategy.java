package service.pricing;

import java.time.Duration;
import java.time.LocalDateTime;

public class CarPricingStrategy implements PricingStrategy {

    @Override
    public double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime) {

        long hours = Duration.between(entryTime, exitTime).toHours();
        if (hours == 0) hours = 1;

        return hours * 20.0;
    }
}
