package com.example.tutorialmod.item.custom;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.tags.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Prospector extends Item {
    private static final Logger log = LoggerFactory.getLogger(Prospector.class);

    public Prospector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();

        if(!world.isClient()){
            boolean foundBlock = false;
            if(!Screen.hasShiftDown()){
                // Fuzzy Search
                for(int i=0; i<pos.getY()+64; i++){
                    for(int j=0; j<5; j++){
                        for(int k=0; k<5; k++)
                        {
                            BlockPos pos1 = pos.down(i).north(j).east(k);
                            BlockState blockState = world.getBlockState(pos1);
                            String name = blockState.getBlock().getName().getString();

                            if(isRightBlock(blockState)){
                                player.sendMessage(Text.of("Found " + name + "!"));
                                String oreLocation = pos1.getY() + " " + pos1.getX();
                                player.sendMessage(Text.of("Location " + oreLocation + "!"));
                                foundBlock = true;
                                break;
                            }
                        }
                    }
                }
                if(!foundBlock)
                {
                    player.sendMessage(Text.of("No ore found!"));
                }
                context.getStack().damage(1, player, EquipmentSlot.MAINHAND);
            }
            else
            {
                // Precise Search
                for(int i=0; i<pos.getY() + 128; i++){
                    BlockPos pos1 = pos.down(i);
                    BlockState blockState = world.getBlockState(pos1);
                    String name = blockState.getBlock().getName().getString();

                    if(isRightBlock(blockState)){
                        player.sendMessage(Text.of("Found " + name + "!"));
                        foundBlock = true;
                        break;
                    }
                }
                if(!foundBlock){
                    player.sendMessage(Text.of("No ore found!"));
                }
                context.getStack().damage(2, player, EquipmentSlot.MAINHAND);
            }
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    private boolean isRightBlock(BlockState blockState) {
        return blockState.isIn(ModBlockTags.ORE_LIST);
    }
}
