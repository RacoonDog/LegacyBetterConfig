package dev.xpple.betterconfig.api;

import net.legacyfabric.fabric.api.command.v2.lib.sponge.CommandNotFoundException;

import java.nio.file.Path;

public interface ModConfig {
    /**
     * Get the identifier of the mod of this configuration.
     * @return the mod's identifier
     */
    String getModId();

    /**
     * Get the class where all the configurations for this mod are defined.
     * @return the class with all configurations
     */
    Class<?> getConfigsClass();

    /**
     * Get the path where the configurations for this mod are stored.
     * @return the path
     */
    Path getConfigsPath();

    /**
     * Gets the underlying config value based on the key, ignoring custom getters.
     * @param config the config's key
     * @return the raw config value
     */
    Object getRawValue(String config);

    /**
     * Get a config value based on the key.
     * @param config the config's key
     * @return the config value
     */
    Object get(String config);

    /**
     * Get the string representation for this config key.
     * @param config the config's key
     * @return the string representation
     */
    String asString(String config);

    /**
     * Reset the value for the config associated with this config key.
     * @param config the config's key
     * @throws IllegalArgumentException when there is no config associated to this key
     */
    void reset(String config);

    /**
     * Set the value for the config associated with this config key.
     * @param config the config's key
     * @param value the new value
     * @throws IllegalArgumentException when there is no setter for this config
     * @throws CommandNotFoundException when a custom setter has failed to execute
     */
    void set(String config, Object value) throws CommandNotFoundException;

    /**
     * Add a value to the config associated with this config key.
     * @param config the config's key
     * @param value the value
     * @throws IllegalArgumentException when there is no adder for this config
     * @throws CommandNotFoundException when a custom adder has failed to execute
     */
    void add(String config, Object value) throws CommandNotFoundException;

    /**
     * Put a new mapping to the config associated with this config key.
     * @param config the config's key
     * @param key the mapping's key
     * @param value the mapping's value
     * @throws IllegalArgumentException when there is no putter for this config
     * @throws CommandNotFoundException when a custom putter has failed to execute
     */
    void put(String config, Object key, Object value) throws CommandNotFoundException;

    /**
     * Remove a value from the config associated with this config key.
     * @param config the config's key
     * @param value the value
     * @throws IllegalArgumentException when there is no remover for this config
     * @throws CommandNotFoundException when a custom remover has failed to execute
     */
    void remove(String config, Object value) throws CommandNotFoundException;

    /**
     * Reset all the {@link Config#temporary()} configs.
     */
    void resetTemporaryConfigs();

    /**
     * Save this configuration.
     * @return {@code true} if the configuration was successfully saved, {@code false} otherwise
     */
    boolean save();
}
