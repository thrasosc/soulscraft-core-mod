# SoulsCraft Core Mod

<details>
   <summary>Making an Example Dependent Mod</summary>

   We will make a dependent mod using the SoulsCraft core mod as a dependency.
   
   First, install the Minecraft Development plugin for IntelliJ. In IntelliJ, create a new project and select "Minecraft" from the generators. Select "Architectury" from the "Templates", and then fill in the name of the mod at the top. The default "Main Class" name is a bit messed up, so make sure to rename it using [PascalCase](https://www.theserverside.com/definition/Pascal-case). In the end it should look something like this:

   <p align="center">
      <img width="700" alt="IntelliJ Project Template" src="https://github.com/user-attachments/assets/8afcd699-ea25-4281-a6bb-e96f095a552b" />
   </p>
   
   After creating the project, wait for it to finish building. Then, in the root `build.gradle` file, include the following in the `repositories` inside of `subprojects`:
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
   
   Before rebuilding, we need to set up the `GITHUB_ACTOR` and `GITHUB_TOKEN` environment variables in order to be authenticated when accessing the SoulsCraft packages (this is a limitation of hosting artifacts on GitHub).
   
   To create a token on GitHub, go to https://github.com/settings/tokens and click on `Generate new token`. Make sure to generate a classic token for general use. Name your token whatever you want (e.g. "SoulsCraft Artifact Publishing"), set a long expiration date (e.g. 90 days), and tick `write:packages` & `delete:packages`, then scroll to the bottom and select `Generate token`. Copy the created token and store it somewhere safe until we set it as an environment variable. Follow [this tutorial](https://youtu.be/5BTnfpIq5mI) for creating an environment variable on Windows, and make sure to create the following two environment variables:
   - `GITHUB_ACTOR`: this will hold the value of your GitHub username.
   - `GITHUB_TOKEN`: this will hold the value of the token we created.

   After setting these environment variables, restart IntelliJ and rebuild your project.
</details>

---

## Useful Abstractions

- [SoulsCraftArmorItem](https://github.com/thrasosc/soulscraft-core-mod/blob/main/common/src/main/java/net/pixeldreamstudios/soulscraft/item/armor/SoulsCraftArmorItem.java) for implementing armor (see [NightRiderArmorItem](https://github.com/thrasosc/soulscraft-core-mod/blob/main/example-mod/common/src/main/java/net/pixeldreamstudios/soulscraft_tarnished_legacy/item/armor/sets/NightRiderArmorItem.java) for example implementation).
- [CapeArmorModel](https://github.com/thrasosc/soulscraft-core-mod/blob/main/common/src/main/java/net/pixeldreamstudios/soulscraft/item/armor/client/model/CapeArmorModel.java) for implementing armor models which have capes attached (see [NightRiderArmorModel](https://github.com/thrasosc/soulscraft-core-mod/blob/main/example-mod/common/src/main/java/net/pixeldreamstudios/soulscraft_tarnished_legacy/item/armor/client/model/NightRiderArmorModel.java) for example implementation).

---

## Registers

To register an item call `SoulsCraftItemRegistry.register()` and provide the mod ID, item ID, and an item supplier as parameters. Example registry class:
```java
public class ItemRegistry {
    public static void init() {
        SoulsCraftItemRegistry.registerItem(TestMod.MOD_ID, "test_item", () -> new Item(new Item.Properties()));
    }
}
```

After calling `ItemRegistry.init()` in your main class, make sure to call `SoulsCraftItemRegistry.init(TestMod.MOD_ID)` *after* it.
