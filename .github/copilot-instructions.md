
# Copilot Instructions for AI Coding Agents

## Project Overview
- **Type:** Java Spring Boot application
- **Purpose:** Manages vocabulary words and study days, likely for a language learning tool
- **Key Modules:**
  - `controller/`: Handles REST HTTP requests (see `DayController.java`, `WordController.java`)
  - `mapper/`: MyBatis XML mappers for database access (see `WordMapper.xml`, `DayMapper.xml`)
  - `resources/`: Configuration and SQL mapping files

## Architecture & Data Flow
- **Entry Point:** `BackWordApplication.java` (Spring Boot main class)
- **Controllers:**
  - `DayController` and `WordController` expose REST endpoints for CRUD operations on days and words
- **Persistence:**
  - Uses MyBatis XML mappers (`WordMapper.xml`, `DayMapper.xml`) to map SQL to Java objects
  - Main table: `tbl_word` (fields: `d_seq`, `w_eng`, `w_kor`, `w_remember_yn`, `w_seq`)
- **Configuration:**
  - `application.properties` for DB and app settings

## Developer Workflows
- **Build:**
  - Use `./gradlew build` (or `gradlew.bat build` on Windows)
- **Test:**
  - Use `./gradlew test` (or `gradlew.bat test`)
  - Main test class: `BackWordApplicationTests.java`
- **Run:**
  - Use `./gradlew bootRun` (or `gradlew.bat bootRun`)

## Project Conventions
- **MyBatis:**
  - SQL is defined in XML under `src/main/resources/mapper/`
  - Mapper namespace matches Java interface names (not shown, but implied)
  - Table/column names use lower_snake_case
- **Controllers:**
  - Placed in `controller/` subpackage
  - Use standard Spring `@RestController` and mapping annotations
- **No custom build/test scripts** beyond Gradle defaults

## Integration Points
- **Database:**
  - Relational DB accessed via MyBatis
  - Table/column names are lower_snake_case
- **No external APIs or messaging** detected

## Examples
- To update a word's "remember" status, see the `updateWord` statement in `WordMapper.xml`:
  ```xml
  <update id="updateWord">
      UPDATE tbl_word
      SET w_eng = #{w_eng},
          w_kor = #{w_kor},
          w_remember_yn = #{w_remember_yn}
      WHERE w_seq = #{w_seq}
  </update>
  ```
- To add a new word:
  ```xml
  <insert id="insertWord">
      INSERT INTO tbl_word (d_seq, w_eng, w_kor)
      VALUES (#{d_seq}, #{w_eng}, #{w_kor})
  </insert>
  ```

## Key Files & Directories
- `src/main/java/com/word/back_word/controller/` — REST controllers
- `src/main/resources/mapper/` — MyBatis XML mappers
- `src/main/resources/application.properties` — Configuration
- `build.gradle` — Build configuration

---

**If you are unsure about a workflow or pattern, check for conventions in the above files before introducing new ones.**
