package com.itemclarity;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ItemClarityPluginTest
{
    // RuneLite's plugin loader uses a generic varargs parameter
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ItemClarityPlugin.class);
		RuneLite.main(args);
	}
}