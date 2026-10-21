package com.emptycontainerdimmer;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class EmptyContainerDimmerPluginTest
{
    // RuneLite's plugin loader uses a generic varargs parameter
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(EmptyContainerDimmerPlugin.class);
		RuneLite.main(args);
	}
}
