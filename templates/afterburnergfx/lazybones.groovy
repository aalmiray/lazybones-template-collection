import uk.co.cacoethes.util.NameType

Map props = [:]
File projectDir = targetDir instanceof File ? targetDir : new File(String.valueOf(targetDir))
props.project_name = transformText(projectDir.name, from: NameType.HYPHENATED, to: NameType.PROPERTY)
props.project_capitalized_name = props.project_name.capitalize()
props.project_group_id = ask("Define value for 'group' [org.example]: ", "org.example", "group")
props.project_version = ask("Define value for 'version' [0.1.0-SNAPSHOT]: ", "0.1.0-SNAPSHOT", "version")
props.project_package_name = ask("Define value for 'packageName' ["+ props.project_group_id +"]: ", props.project_group_id, "packageName")
props.project_afterburnergfx_version = ask("Define value for 'afterburnerGfxVersion' [0.2.1]: ", "0.2.1", "afterburnerGfxVersion")

processTemplates 'build.gradle', props
processTemplates 'gradle.properties', props
processTemplates 'src/main/groovy/*.java', props

String packagePath = props.project_package_name.replace('.' as char, '/' as char)

File sources = new File(projectDir, 'src/main/groovy')
File resources = new File(projectDir, 'src/main/resources')

File sourcesPath = new File(sources, packagePath)
sourcesPath.mkdirs()
File resourcesPath = new File(resources, packagePath)
resourcesPath.mkdirs()

sources.eachFile { File file ->
   file.renameTo(sourcesPath.absolutePath + '/' + props.project_capitalized_name + file.name)
}

File groovyfxView = new File(resources, 'app.groovyfx')
groovyfxView.renameTo(resourcesPath.absolutePath + '/' + props.project_name + '.groovyfx')
