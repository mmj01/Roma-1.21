package Roma.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties WHEAT = new FoodProperties
            .Builder()
            .nutrition(4)
            .saturationModifier(2)
            .alwaysEdible()
            .usingConvertsTo(Moditems.WHEATSEEDS.get())
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 1),1.0f)
            .build();
}
