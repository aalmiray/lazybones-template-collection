def getPropertyNameRepresentation(String name) {
    if (!name) return name
    // Strip any package from the name.
    int pos = name.lastIndexOf('.')
    if (pos != -1) {
        name = name.substring(pos + 1)
    }

    // Check whether the name begins with two upper case letters.
    if (name.length() > 1 && Character.isUpperCase(name.charAt(0)) && Character.isUpperCase(name.charAt(1))) {
        return name
    }

    String propertyName = name.substring(0, 1).toLowerCase(Locale.ENGLISH) + name.substring(1)
    if (propertyName.indexOf(' ') > -1) {
        propertyName = propertyName.replaceAll("\\s", "")
    }
    return propertyName
}

def getClassNameForLowerCaseHyphenSeparatedName(String name) {
    // Handle null and empty strings.
    if (!name) return name

    if (name.indexOf('-') > -1) {
        StringBuilder buf = new StringBuilder()
        String[] tokens = name.split("-")
        for (String token : tokens) {
            if (token == null || token.length() == 0) continue
            buf.append(token.capitalize())
        }
        return buf.toString()
    }

    return name.capitalize()
}

Map props = [:]
props.project_group_id = ask("Define value for 'group' [org.example]: ", "org.example", "group")
props.project_version = ask("Define value for 'version' [0.1.0-SNAPSHOT]: ", "0.1.0-SNAPSHOT", "version")
props.project_package_name = ask("Define value for 'packageName' ["+ props.project_group_id +"]: ", props.project_group_id, "packageName")
props.afterburner_version = ask("Define value for 'afterburnerVersion' [1.1]: ", "1.1", "afterburnerVersion")

File projectDir = targetDir instanceof File ? targetDir : new File(String.valueOf(targetDir))
props.project_name = getPropertyNameRepresentation(getClassNameForLowerCaseHyphenSeparatedName(projectDir.name))
props.project_capitalized_name = props.project_name.capitalize()

processTemplates 'build.gradle', props
processTemplates 'gradle.properties', props
processTemplates 'pom.xml', props
processTemplates 'src/main/java/*.java', props
processTemplates 'src/main/resources/*.fxml', props

String packagePath = props.project_package_name.replace('.' as char, '/' as char)

File sources = new File(projectDir, 'src/main/java')
File resources = new File(projectDir, 'src/main/resources')

File sourcesPath = new File(sources, packagePath)
sourcesPath.mkdirs()
File resourcesPath = new File(resources, packagePath)
resourcesPath.mkdirs()

sources.eachFile { File file ->
   file.renameTo(sourcesPath.absolutePath + '/' + props.project_capitalized_name + file.name) 
}

File fxmlView = new File(resources, 'app.fxml')
fxmlView.renameTo(resourcesPath.absolutePath + '/' + props.project_name + '.fxml')
