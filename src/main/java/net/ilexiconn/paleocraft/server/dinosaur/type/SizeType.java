package net.ilexiconn.paleocraft.server.dinosaur.type;

public enum SizeType {
    TINY(5.0F),
    SMALL(10.0F),
    MEDIUM(50.0F),
    LARGE(100.0F),
    HUGE(200.0F);

    private final float health;

    SizeType(float health) {
        this.health = health;
    }

    public float getHealth() {
        return health;
    }
}
