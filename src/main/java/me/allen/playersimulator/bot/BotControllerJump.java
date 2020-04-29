package me.allen.playersimulator.bot;

import net.minecraft.server.v1_8_R3.ControllerJump;
import net.minecraft.server.v1_8_R3.EntitySheep;

public class BotControllerJump
        extends ControllerJump {
    private final EntityBot a;
    private boolean b;

    public BotControllerJump(EntityBot bot) {
        super(new EntitySheep(bot.world));
        this.a = bot;
    }

    public void a() {
        this.b = true;
    }

    public void b() {
        this.a.f(this.b);
        this.b = false;
    }
}