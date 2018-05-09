package org.mafagafogigante.dungeon.entity.items;

import org.mafagafogigante.dungeon.game.Game;

import org.jetbrains.annotations.NotNull;
import org.mafagafogigante.dungeon.game.GameState;

/**
 * Uninstantiable class that handles item breakage via a handleBreakage(Item) method.
 */
public final class BreakageHandler {


  /**
   * Handles an item breakage.
   *
   * @param item the Item object that just broke, not null, broken
   */
  static void handleBreakage(@NotNull Item item, @NotNull GameState gameState) {
    if (!item.isBroken()) {
      throw new IllegalArgumentException("item should be broken.");
    }
    if (!item.hasTag(Item.Tag.REPAIRABLE)) {
      item.getInventory().removeItem(item);
      return; // The Item object will disappear from the game, don't worry about its state.
    }
    if (item.hasTag(Item.Tag.CLOCK)) {
      // A clock just broke! Update its last time record.
      item.getClockComponent().setLastTime(gameState.getWorld().getWorldDate());
    }
  }

}
