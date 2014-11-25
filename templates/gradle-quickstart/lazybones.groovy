import uk.co.cacoethes.util.NameType

String username = System.properties['user.name']
Map props = [:]
props.project_name = transformText(projectDir.name, from: NameType.CAMEL_CASE, to: NameType.HYPHENATED)
props.project_group = ask("Define value for 'group' [org.example]: ", 'org.example', 'group')
props.project_version = ask("Define value for 'version' [0.1.0-SNAPSHOT]: ", '0.1.0-SNAPSHOT', 'version')
props.project_vendor = ask("Define value for 'vendor' [${props.project_name}]: ", props.project_name, 'vendor')
props.project_description = ask("Define value for 'description' [${props.project_name}]: ", 'props.project_name', 'description')
props.project_url = ask("Define value for 'url' [https://github.com/${username}/${props.project_name}]: ", "https://github.com/${username}/${props.project_name}".toString(), 'url')
props.project_scm = ask("Define value for 'scm' [https://github.com/${username}/${props.project_name}.git]: ", "https://github.com/${username}/${props.project_name}.git".toString(), 'scm')
props.project_issues = ask("Define value for 'issues' [https://github.com/${username}/${props.project_name}/issues]: ", "https://github.com/${username}/${props.project_name}/issues".toString(), 'issues')
props.project_bintray_repo = ask("Define value for 'bintray repo' [maven]: ", 'maven', 'bintray_repo')
props.project_bintray_org = ask("Define value for 'bintray org' [$username]: ", username, 'bintray_org')

processTemplates 'gradle.properties', props

