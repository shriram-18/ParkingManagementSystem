package service.pricing;

import java.time.LocalDateTime;

public interface PricingStrategy {

    double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime);
}
