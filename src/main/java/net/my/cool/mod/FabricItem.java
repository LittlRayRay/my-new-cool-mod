package net.my.cool.mod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FabricItem extends Item{
    public FabricItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.ENTITY_GHAST_SCREAM, 5.0f, 1.0f);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
