
## IN DEV 1.0.0

### New Additions -

#### Platform Support -
- Full Fabric support for 1.19.2 and 1.20.1
- NeoForge support for 1.21.1 (Create Fabric skipping 1.21.1 entirely)
- Combined Fabric/Forge jars using [Forgix](https://github.com/PacifistMC/Forgix)

#### New Items -
- Echo Shard dust + Recipe
- Ender Pearl Dust + Recipe
- Heart of the Sea fragments (craftable into full Heart of the Sea with 2 fragments)
- Nautilus Shell fragments (craftable into Nautilus Shell with 2 fragments)
- Redstone Link Frequency items (1-32) for frequency management

#### New Custom Processing Types -
- Dye Splashing (fan-based dyeing with dyed waters)
- Molten Blasting (custom fluid smelting/processing)
- Advanced Assembly (Sequenced assembly with more recipe types available)

#### Fluid Interactions & Mechanics -
- Molten Endstone, Liquid Redstone, and Liquid Quartz now deal fire damage when stepped in
- Molten Endstone, Liquid Redstone, and Liquid Quartz now react with water, producing specific blocks
- Dyed Waters can dye items with dyed variants (Stained Glass, Wool, Terracotta, etc.)
- Items now properly interact with all CMF fluids (burning in molten fluids, floating in dyed waters)
- All molten fluids and dyed waters have custom sounds and particles


#### Configuration System -
- Master config system to disable recipes by category and individual recipe level
- Toggle Molten/Liquid Redstone/Quartz water interactions
- Configurable blocks produced when molten fluids touch water

### Changes & Balances -

#### Architecture & Infrastructure -
- 1.19.2 & 1.20.1: Complete rewrite from single-platform Forge to multi-platform using [Architectury API](https://modrinth.com/mod/architectury-api)
- 1.21.1: purely Neoforge, fabric support dropped.
- All versions: Adopted [ResourcefulLib](https://modrinth.com/mod/resourceful-lib) and [ResourcefulConfig](https://modrinth.com/mod/resourceful-config) for configuration management


#### Dependency Updates -
- 1.19.2: Create 0.5.1.i 
- 1.20.1: Create 6.0.8
- 1.21.1: Create 6.0.10-280+
- All versions use Create 0.5.1+ or later versions
- ResourcefulLib and ResourcefulConfig 

### Fixes -

- Fixed liquid amounts in recipes on Fabric platforms
- Improved fluid tank and basin compatibility across platforms

### Credits -

#### Textures -
- Echo Shard dust & Ender Pearl dust - [v3lsk](https://github.com/v3lsk)
- Nautilus Shell fragment & Heart of the Sea fragment - [v3lsk](https://github.com/v3lsk)
- Molten Endstone, Liquid Redstone, and Liquid Quartz buckets - [v3lsk](https://github.com/v3lsk)

---
## 0.8.2

### New additions & changes

- Updated Dyed Water bucket Textures - [v3lsk](https://github.com/v3lsk)
- Updated Dye Template Textures - [v3lsk](https://github.com/v3lsk)
- Added Emerald to Sifting Recipe
- Added Liquid Quartz
- New Mixing & Sequenced Assembly Recipes for Diorite
- New Mixing Recipe for Andesite
- New recipe with Create more recipes for Dying Sand → Red sand
- New Haunting recipe for Redstone -> Glowstone

### Fixes

- Fixed orestone crushing recipes not replacing Creates base recipes [#4](https://github.com/Rockiecraft/Create-More-Farmables/issues/4)

---


## 0.8.1 HOTFIX
## Update to Create 0.5.1.j-55

### changes -
- Create enchantment industry is no longer required. 
### changelog from the Create update
#### "Fixed crash when recipes contain invalid fluid ingredients (IThundxr)"  
#### which fixes the crash caused when CEI is not installed and CMF is installed. Experience fluid from CEI was required in a recipe from CMF.

---
## 0.8
## New additions & changes
I'll get to updating fabric ver eventually (if I ever feel like it, I hate working in fabric)

### Creative Tab changes -

- separated code into its own separate file for creative mode tabs
- added CMF buckets to TOOLS_AND_UTILITIES tab
- added CMF ingredients to the ingredients tab

### Fluid changes -

- Molten endstone is no longer infinite. you need to make more by melting it down and compacting it onto cobblestone

### Recipe Changes -

- added and increased chances for not so desired items to sifting recipes for balancing

### New Items -

- Netherite Dust
- Unprocessed Netherite Dust
- Unprocessed Blaze Rod

### New Liquid -

- Liquid Redstone

### New Recipes -

#### these custom splashing recipes require another mod to work (these recipes are only on the forge ver)
installing said mod is optional though. you just won't be able to use these recipes without it. [Create: More Recipes](https://www.curseforge.com/minecraft/mc-mods/create-morerecipes)

#### Custom splashing - (forge)
- using dyed water in front of a fan can be used to stain glass and dye wool
- using dyed water in front of a fan can be used to dye beds and banners

#### filling and haunting -
- spouting lava onto netherack makes magmablocks 
- haunting basalt makes netherack

#### Mixing recipes  -
- mixing cinder flour and iron nuggets in a heated basin makes redstone
- mixing redstone in a heated basin makes Liquid redstone 
- mixing powdered obsidian and cinder flour in a superheated basin makes netherite dust


#### Splashing recipes -
- splashing magmablocks turns them into obsidian

#### Sequenced Assembly recipes -
###### The netherite recipe will require [Create Enchantment Industry](https://www.curseforge.com/minecraft/mc-mods/create-enchantment-industry)
- stick to blazerod using cinder flour, lava and pressing **1X loop**
- Turn Certus Quartz(AE2) or Quartz into Rose Quartz(Create) using Liquid Redstone by Spouts **1X loop**
- netherite dust to netherite scrap using, experience, lava and pressing  **5X loops**
---
## 0.7

### Port to fabric! 

### Added to Fabric & Forge

- tags to dyed water(water) and molten endstone(lava)
---
## 0.6
Sort of in and out of developing the mod cause busy or doing other things in coding. 
### changes

- Molten endstone textures
- Shulker Compound textures

### Added

#### Client
- Overlay for the Dyed Water
#### item/block
- Wood String
- Wood String Wool Block
#### Recipes
- Dirt Recipe
- Red Sand Recipe
- Wood String Recipe
- Wood String Wool Recipe
#### Create sifter recipes (only on forge ver)
- Create sifter recipes, different recipe sifting for gravel, red sand, sand, and a new one for wet sponges.
- Increased chances for materials from sifting gravel in advanced brass mesh and brass sifter
- Increased chances for materials from sifting sand in advanced brass mesh and brass sifter
- Increased chances for materials from sifting red sand in advanced brass mesh and brass sifter 

### fixed

- Log Being spammed with "Exception loading blockstate definition: 'create_more_farmables:blockstates/.json' missing model for variant: 'create_more_farmables:#level=x"
---

## 0.3 

### Changes

- Code base for fluid and items.

### Added
- Recipes
- heated mixing: stone + blue dyed water -> Asurine
- Better chance of Crushed Raw zinc/zinc nuggets from crushing Asuruine
- heated mixing: stone + red dyed water -> Crimsite
- Better chance of Crushed Raw Iron/Iron nuggets from crushing Crimsite
- heated mixing: Dripstone block + yellow dyed water -> Ochrum
- Better chance of Crushed Raw Gold/Gold nuggets from crushing Ochrum
- heating mixing: stone + white dyed water -> calcite
- heated mixing: cobblestone + green dyed water -> Veridium
- haunting andesite -> netherrack
  
### fixes

- buckets from this mod now works correctly with create fluid tanks/basins/fluid drains

---
## 0.2 

### Changes

- Molten Endstone texture
  
### Added 

- Dyed Water
- Dyed Water buckets
- Dye Template
- Recipes to automate Minecraft dye
  
---
## 0.1 

### First verson

- Brings, shulker compound, shulker shell fragments, molten endstone.
- Recipes to automate shulker shells
