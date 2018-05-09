package org.mafagafogigante.dungeon.map;

import org.mafagafogigante.dungeon.game.Location;

import org.jetbrains.annotations.NotNull;

import java.awt.Color;

/**
 * A symbol in a WorldMap.
 */
class WorldMapSymbol {

  private static final WorldMapSymbol HERO_SYMBOL = new WorldMapSymbol('@', Color.WHITE);
  private static final WorldMapSymbol NOT_YET_GENERATED_SYMBOL = new WorldMapSymbol('~', Color.GRAY);

  private final String character;
  private final Color color;

  private WorldMapSymbol(char character, @NotNull Color color) {
    this.character = String.valueOf(character);
    this.color = color;
  }

   static WorldMapSymbol makeSymbol(@NotNull Location location) {
    return new WorldMapSymbol(location.getDescription().getSymbol(), location.getDescription().getColor());
  }

   static WorldMapSymbol getHeroSymbol() {
    return HERO_SYMBOL;
  }

   static WorldMapSymbol getNotYetGeneratedSymbol() {
    return NOT_YET_GENERATED_SYMBOL;
  }

   String getCharacterAsString() {
    return character;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "WorldMapSymbol{" +
        "character='" + character + '\'' +
        ", color=" + color +
        '}';
  }

}
