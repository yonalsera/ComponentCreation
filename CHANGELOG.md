# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.02/04

### Added

- Added `/bin` to `.gitignore`, so binaries are no longer committed
- Added the TODO tree extensions to `extensions.json`
- Added the `todo-tree.general.showActivityBarBadge` setting to `settings.json`
- Added the `todo-tree.tree.showCountsInTree` setting to `settings.json`
- Added the VSCode PDF extension to `extensions.json`
- Added `java.debug.settings.vmArgs` setting to enable assertions (i.e., `-ea`)
- Added information about making branches to all parts of the project
- Added information about how to update the CHANGELOG to every part of the
  project
- Added information about how to make a pull request to every part of the
  project

### Changed

- Updated `settings.json` to format document on save using `editor.formatOnSave`
  setting
- Updated `settings.json` to exclude certain files from markdown to PDF
  generation using `markdown-pdf.convertOnSaveExclude` setting
- Updated `settings.json` to use latest `java.cleanup.actions` setting
- Updated `settings.json` to automatically choose line endings using `files.eol`
  setting
- Updated `settings.json` to organize imports automatically on save using the
  `editor.codeActionsOnSave` and `source.organizeImports` settings
- Changed the component brainstorming assignment to ask a few clarifying
  questions
- Changed the component brainstorming example from `Point3D` to `NaturalNumber`
  to avoid the getter/setter trend
- Updated assignment feedback sections to include a link to a survey that
  I'll actually review
- Updated README to include step about using template repo
- Updated part 3 rubric to include a hierarchy diagram
- Updated part 6 rubric to account for overall polish

### Fixed

- Fixed issue where checkstyle paths would not work on MacOS

### Removed

- Removed `java.saveActions.organizeImports` setting from `settings.json`
- Removed references to `Point3D` completely

## [2024.01.07]

### Added

- Added a list of extensions to capture the ideal student experience
- Added PDFs to the `.gitignore`
- Added the OSU checkstyle config file
- Added the OSU formatter config file
- Added a `settings.json` file to customize the student experience
- Created a README at the root to explain how to use the template repo
- Created initial drafts of the six portfolio assessments
- Added READMEs to key folders like `test` and `lib` to explain their purpose

[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07

## [2025.03.03]

### Added

- Designed kernel and enhanced interfaces for MusicPlaylist component

### Updated

- Changed design to include thorougly established interfaces for the kernel and secondary methods within MusicPlaylist, more specifically the return type and parameters.

## 2025.02.20

### Added

- Designed a proof of concept for MusicPlaylist component

### Updated

- Changed design to include an additional two kernel methods, being clear() and hasSong().
- Completed an initial implementation for all kernel methods (isEmpty(), add(), remove(), clear(), hasSong()) and two secondary methods (merge() and getArtist()).
- Changed MusicPlaylist component to be based off a sequence of map pairs rather than a map to allow for greater flexibility and easier access to indivual pairs (otherwise known as the songs).
- Provided informal testing of methods for proof of their viability.

## 2025.04.13

### Added

- Designed abstract class for MusicPlaylit component

### Updated

- Changed design to include a different variation of kernel methods and secondary methods
- Deletion of the getPath() method.


## [2025.04.15]

### Added

- Designed kernel implementation for MusicPlaylist component

### Updated

- Changed design so merge method is now a secondary method.

# [2025.04.18]

### Added

- Designed test suite for MusicPlaylist component
- Designed two different use cases for MusicPlaylist component

### Updated

- Changed design to include Song class instead of taking in two strings, allowing for greater flexibility for the implementor and user. Object is now a Sequence of Song objects
- Made multiple changes to the interface and layering of MusicPlaylist, and swtiched various methods like merge
- Updated method contracts to include more information and changed all used of Map.Pair to be Song objects

