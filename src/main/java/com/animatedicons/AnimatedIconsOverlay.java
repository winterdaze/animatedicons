package com.animatedicons;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.inject.Inject;
import javax.swing.ImageIcon;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

@Slf4j
public class AnimatedIconsOverlay extends WidgetItemOverlay
{
    @Inject
    private AnimatedIconsOverlay()
    {
        showOnEquipment();
        showOnInventory();
        showOnBank();
    }

    @Override
    public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
    {
        final Icon icon = Icon.getAnimatedIcon(itemId);
        if (icon != null)
        {
            Rectangle bounds = itemWidget.getCanvasBounds();
            int defaultItemID = icon.getDefaultID();
            final Image animatedIcon = new ImageIcon(AnimatedIconsPlugin.class.getClassLoader().getResource(defaultItemID + ".gif")).getImage();
            graphics.drawImage(animatedIcon, (int) bounds.getX(), (int) bounds.getY(), null);
        }
    }
}
