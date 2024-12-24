# SoulsCraft Core Mod

<details>
   <summary>Making an Example Dependent Mod</summary>

   We will make a dependent mod using the SoulsCraft core mod as a dependency.
   
   First, install the Minecraft Development plugin for IntelliJ. In IntelliJ, create a new project and select "Minecraft" from the generators. Select "Architectury" from the "Templates", and then fill in the name of the mod at the top. The default "Main Class" name is a bit messed up, so make sure to rename it using [PascalCase](https://www.theserverside.com/definition/Pascal-case). In the end it should look something like this:

   ![project template](...)
   
   After creating the project, wait for it to finish building. Then, in the root `build.gradle` file, include the following in the `repositories` inside of `subprojects`:
   ```groovy
   maven { url 'https://maven.azuredoom.com/mods' }
   mavenLocal()
   ```
   The `mavenLocal()` repository will be explained later.
   
   In `common/build.gradle` include the following dependencies:
   ```groovy
   modImplementation "mod.azure.azurelib:azurelib-common-${minecraft_version}:${azurelib_version}"
   modImplementation "net.pixeldreamstudios:soulscraft-common:${soulscraft_version}"
   ```
   
   In `fabric/build.gradle` include the following dependencies:
   ```groovy
   modImplementation "mod.azure.azurelib:azurelib-fabric-${minecraft_version}:${azurelib_version}"
   modImplementation "net.pixeldreamstudios:soulscraft-fabric:${soulscraft_version}"
   ```
   
   In `neoforge/build.gradle` include the following dependencies:
   ```groovy
   modImplementation "mod.azure.azurelib:azurelib-neo-${minecraft_version}:${azurelib_version}"
   modImplementation "net.pixeldreamstudios:soulscraft-neoforge:${soulscraft_version}"
   ```
   
   Before rebuilding, clone the latest version of the SoulsCraft core mod:
   ```shell
   git clone git@github.com:thrasosc/soulscraft-core-mod.git
   ```
   
   Open the core mod in IntelliJ and wait for it to finish building. Then, run the `publishToMavenLocal` task. This will publish the artifacts to your local Maven repository at `~/.m2/repository`. The `mavenLocal()` dependency we included previously gives our project access to the `~/.m2/repository` directory.

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
        SoulsCraftItemRegistry.registerItem(SoulsCraftTest.MOD_ID, "test_item", () -> new Item(new Item.Properties()));
    }
}
```

---

## Core Mod Changes

If you make any changes to the core mod, you need to follow these steps in order for the changes to take effect in the dependent mods. Simply refreshing your gradle after publishing to maven local will not work; you need to delete the caches.
1. In the core mod, run the `publishToMavenLocal` task and wait for it to finish.
2. Close the dependent mod from IntelliJ.
3. Delete the following directories in the dependent mod (make sure hidden files are visible):
   - `.gradle`
   - `.idea`
   - `common/.gradle`
   - `common/build`
   - `fabric/.gradle`
   - `fabric/build`
   - `neoforge/.gradle`
   - `neoforge/build`
4. Open the dependent mod in Intellij and wait for it to build.