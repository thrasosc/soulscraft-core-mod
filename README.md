# SoulsCraft Core Mod

---

## Useful Abstractions

Below are a few abstractions I created to simplify the process of registering new items, creating new armor sets, and triggering animations.

- [SoulsCraftItemRegistry](https://github.com/thrasosc/soulscraft-core-mod/blob/main/common/src/main/java/net/pixeldreamstudios/soulscraft/registry/SoulsCraftItemRegistry.java) (see the [example mod ItemRegistry](https://github.com/thrasosc/soulscraft-core-mod/blob/main/example-mod/common/src/main/java/net/pixeldreamstudios/soulscraft_tarnished_legacy/registry/ItemRegistry.java) for reference)
- [SoulsCraftArmorDispatcher](https://github.com/thrasosc/soulscraft-core-mod/blob/main/common/src/main/java/net/pixeldreamstudios/soulscraft/item/armor/client/dispatcher/SoulsCraftArmorDispatcher.java) (no example yet, use it to trigger preset animations - see the [AzureLib wiki](https://moddedmc.wiki/en/project/azurelib/docs/armor/armor) for reference and replace `ExampleArmorDispatcher` with `SoulsCraftArmorDispatcher`)
- [SoulsCraftArmorItem](https://github.com/thrasosc/soulscraft-core-mod/blob/main/common/src/main/java/net/pixeldreamstudios/soulscraft/item/armor/sets/SoulsCraftArmorItem.java) (see the [example mod NightRiderArmorItem](https://github.com/thrasosc/soulscraft-core-mod/blob/main/example-mod/common/src/main/java/net/pixeldreamstudios/soulscraft_tarnished_legacy/item/armor/sets/NightRiderArmorItem.java) for reference)
- [SoulsCraftArmorAnimator](https://github.com/thrasosc/soulscraft-core-mod/blob/main/common/src/main/java/net/pixeldreamstudios/soulscraft/item/armor/client/animator/SoulsCraftArmorAnimator.java) (see the [example mod NightRiderArmorAnimator](https://github.com/thrasosc/soulscraft-core-mod/blob/main/example-mod/common/src/main/java/net/pixeldreamstudios/soulscraft_tarnished_legacy/item/armor/client/animator/NightRiderArmorAnimator.java) for reference)
- [SoulsCraftArmorRenderer](https://github.com/thrasosc/soulscraft-core-mod/blob/main/common/src/main/java/net/pixeldreamstudios/soulscraft/item/armor/client/renderer/SoulsCraftArmorRenderer.java) (see the [example mod NightRiderArmorRenderer](https://github.com/thrasosc/soulscraft-core-mod/blob/main/example-mod/common/src/main/java/net/pixeldreamstudios/soulscraft_tarnished_legacy/item/armor/client/renderer/NightRiderArmorRenderer.java) for reference)

---

## Registering Items

To register an item call `SoulsCraftItemRegistry.register()` and provide the mod ID, item ID, and an item supplier as parameters. Example registry class:

```java
public class ItemRegistry {
    public static void init() {
        SoulsCraftItemRegistry.registerItem(TestMod.MOD_ID, "test_item", () -> new Item(new Item.Properties()));
    }
}
```

After calling `ItemRegistry.init()` in your **main class initializer**, make sure to call `SoulsCraftItemRegistry.init(TestMod.MOD_ID)` *after* it. Then, in your **client initializer**, call `SoulsCraftItemRegistry.initClient(TestMod.MOD_ID)`.

---

## Concrete Example

Check out the [example mod](https://github.com/thrasosc/soulscraft-core-mod/tree/main/example-mod) to see how to add an armor set to the game using the SoulsCraft framework.

---

## Set Up an Example Dependent Mod

We will make a dependent mod using the SoulsCraft core mod as a dependency.

First, install the Minecraft Development plugin for IntelliJ. In IntelliJ, create a new project and select "Minecraft"
from the generators. Select "Architectury" from the "Templates", and then fill in the name of the mod at the top. The
default "Main Class" name is a bit messed up, so make sure to rename it
using [PascalCase](https://www.theserverside.com/definition/Pascal-case). In the end it should look something like this:

   <p align="center">
      <img width="700" alt="IntelliJ Project Template" src="https://github.com/user-attachments/assets/8afcd699-ea25-4281-a6bb-e96f095a552b" />
   </p>

After creating the project, wait for it to finish building. Then, in the root `build.gradle` file, include the following
in the `repositories` inside of `subprojects`:

   ```groovy
   maven { url 'https://maven.azuredoom.com/mods' }
maven {
    url 'https://maven.pkg.github.com/thrasosc/soulscraft-core-mod'
    credentials {
        username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_ACTOR")
        password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
    }
}
   ```

In `common/build.gradle` include the following dependencies:

   ```groovy
   modImplementation "mod.azure.azurelib:azurelib-common-${minecraft_version}:${azurelib_version}"
modImplementation "net.pixeldreamstudios:soulscraft-${minecraft_version}-common:${soulscraft_version}"
   ```

In `fabric/build.gradle` include the following dependencies:

   ```groovy
   modImplementation "mod.azure.azurelib:azurelib-fabric-${minecraft_version}:${azurelib_version}"
modImplementation "net.pixeldreamstudios:soulscraft-${minecraft_version}-fabric:${soulscraft_version}"
   ```

In `neoforge/build.gradle` include the following dependencies:

   ```groovy
   modImplementation "mod.azure.azurelib:azurelib-neo-${minecraft_version}:${azurelib_version}"
modImplementation "net.pixeldreamstudios:soulscraft-${minecraft_version}-neoforge:${soulscraft_version}"
   ```

Before rebuilding, we need to set up the `GITHUB_ACTOR` and `GITHUB_TOKEN` environment variables in order to be
authenticated when accessing the SoulsCraft packages (this is a limitation of hosting artifacts on GitHub).

To create a token on GitHub, go to https://github.com/settings/tokens and click on `Generate new token`. Make sure to
generate a classic token for general use. Name your token whatever you want (e.g. "SoulsCraft Artifact Publishing"), set
a long expiration date (e.g. 90 days), and tick `write:packages` & `delete:packages`, then scroll to the bottom and
select `Generate token`. Copy the created token and store it somewhere safe until we set it as an environment variable.
Follow [this tutorial](https://youtu.be/5BTnfpIq5mI) for creating an environment variable on Windows, and make sure to
create the following two environment variables:

- `GITHUB_ACTOR`: this will hold the value of your GitHub username.
- `GITHUB_TOKEN`: this will hold the value of the token we created.

After setting these environment variables, restart IntelliJ and rebuild your project. You are now ready to use the SoulsCraft framework in your project.

---