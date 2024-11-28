package com.LunaGlaze.rainbowcompound.Projects.Items.Props;

import com.LunaGlaze.rainbowcompound.LunaUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.RandomUtils;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;


public class HomeMagicMirror extends Item {
    public HomeMagicMirror() {
        super(new Properties().rarity(Rarity.UNCOMMON)
                .stacksTo( 1 ).durability(16) );
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {
        ItemStack itemStack = player.getItemInHand(pUsedHand);
        if(itemStack.getDamageValue() < 16) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);

                var spawnPoint = serverPlayer.getRespawnPosition();
                if (spawnPoint == null || level.isClientSide) {
                    return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemStack);
                }
                    serverPlayer.teleportTo(
                            Objects.requireNonNull(((ServerLevel) level).getServer().getLevel(serverPlayer.getRespawnDimension())),
                            spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ(), serverPlayer.getYRot(), serverPlayer.getVoicePitch()
                    );
            }

            player.awardStat(Stats.ITEM_USED.get(this));

            if (!player.isCreative()) {
                itemStack.getDamageValue();
                itemStack.setDamageValue(itemStack.getDamageValue() + 1);
            }

            player.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.5F, 2F / (RandomUtils.nextFloat() *0.4F + 0.2F));
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemStack);
        }

        return new InteractionResultHolder<>(InteractionResult.PASS, itemStack);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced){
        tooltip.add(Component.translatable(LunaUtils.MOD_ID + ".tooltip.homemagicmirror", new Object[0]).withStyle(ChatFormatting.GRAY));
    }

}
