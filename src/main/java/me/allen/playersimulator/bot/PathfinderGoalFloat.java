package me.allen.playersimulator.bot;


import net.minecraft.server.v1_8_R3.PathfinderGoal;

public class PathfinderGoalFloat
        extends PathfinderGoal {
    private final EntityBot a;

    public PathfinderGoalFloat(EntityBot bot) {
        this.a = bot;
        a(4);
        bot.getNavigation().e(true);
    }

    public boolean a() {
        return (this.a.V()) || (this.a.ab());
    }

    public void e() {
        if (this.a.bc().nextFloat() < 0.8F) {
            this.a.getControllerJump().a();
        }
    }
}