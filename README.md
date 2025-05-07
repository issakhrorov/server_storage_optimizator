# media-cleanup-tool

A pure Java utility that scans your database for unused media references and generates shell scripts to remove orphaned files from the file system. Uses **jOOQ** for typesafe SQL access.

## 🧩 Key Features

- 📊 Scans all database tables with media-related fields
- 🧠 Identifies unused media entries by comparing references
- 🏷️ Marks unused media in a temporary column (`temp = true`)
- 🧹 Generates `delete.sh` script to remove unreferenced files
- ⚙️ Designed for manual or scheduled cleanup jobs

## 🛠️ Technology Stack

- **Language:** Java
- **Database Access:** [jOOQ](https://www.jooq.org/)
- **Database:** PostgreSQL (can be adapted to others)
- **Build Tool:** Maven or Gradle

## 🗃️ Workflow

1. **Collect Media References:**
   - Scans all tables known to contain `media` fields (e.g., `image_id`, `file_id`).
   - Gathers IDs of media currently in use.

2. **Compare with Media Table:**
   - Opens the main `media` table.
   - Marks records with `temp = true` if they are not referenced anywhere.

3. **Generate Delete Script:**
   - For each `temp = true` record, creates a shell command to delete the associated file.
   - Saves commands in a `delete_unused_files.sh` script.

## 🧾 Table Assumptions

- Media files are tracked in a central `media` table with at least:
  - `id`: Primary key
  - `path`: Filesystem path
  - `temp`: Boolean column for marking unused files

- Other tables reference media by storing its ID.

## 🚀 How to Run

1. **Configure Database Access**

Update `application.properties` or equivalent config file:

```properties
db.url=jdbc:postgresql://localhost:5432/your_db
db.user=your_user
db.password=your_password
