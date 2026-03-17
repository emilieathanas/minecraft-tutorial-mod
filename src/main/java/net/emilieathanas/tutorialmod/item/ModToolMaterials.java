package net.emilieathanas.tutorialmod.item;

import net.emilieathanas.tutorialmod.util.ModTags;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Items;

public class ModToolMaterials {
    public static final ToolMaterial PINK_GARNET_TOOL_MATERIAL = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_PINK_GARNET_TOOL,
            1200,
            5.0F,
            5.0F,
            22,
            ModTags.Items.REPAIRS_PINK_GARNET_TOOLS
    );
}
