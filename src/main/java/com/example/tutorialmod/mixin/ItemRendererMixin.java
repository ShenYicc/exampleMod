package com.example.tutorialmod.mixin;

import com.example.tutorialmod.TemplateMod;
import com.example.tutorialmod.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At("HEAD"), argsOnly = true)
    public BakedModel usePlateModel(BakedModel model, ItemStack stack,
                                    ModelTransformationMode renderMode,
                                    boolean leftHanded,
                                    MatrixStack matrices,
                                    VertexConsumerProvider vertexConsumers,
                                    int light,
                                    int overlay
                                    ) {
        boolean bl = renderMode != ModelTransformationMode.GUI;
        if (bl) {
            if (stack.isOf(ModItems.PLATE)) {
                return ((ItemRendererAccessor) this).getModelsField().getModelManager().getModel(
                        ModelIdentifier.ofInventoryVariant(Identifier.of(TemplateMod.MOD_ID, "plate_3d"))
                );
            }
        }
        return model;
    }
}
