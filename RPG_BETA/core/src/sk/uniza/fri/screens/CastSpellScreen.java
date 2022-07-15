package sk.uniza.fri;

import sk.uniza.fri.Creature;
import sk.uniza.fri.Spell;

public class CastSpellScreen extends TargetBasedScreen {
	private Spell spell;
	
	public CastSpellScreen(Creature player, String caption, int sx, int sy, Spell spell) {
		super(player, caption, sx, sy);
		this.spell = spell;
	}
	
	public void selectWorldCoordinate(int x, int y, int screenX, int screenY){
		player.castSpell(spell, x, y);
	}
}
