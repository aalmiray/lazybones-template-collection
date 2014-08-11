import uk.co.cacoethes.util.NameType

Map props = [:]
props.project_name = transformText(projectDir.name, from: NameType.CAMEL_CASE, to: NameType.HYPHENATED)
props.project_group = ask("Define value for 'group' [org.example]: ", 'org.example', 'group')
props.project_version = ask("Define value for 'version' [0.1.0-SNAPSHOT]: ", '0.1.0-SNAPSHOT', 'version')
props.project_vendor = ask("Define value for 'vendor' [${props.project_name}]: ", props.project_name, 'vendor')
props.project_description = ask("Define value for 'description': ", '', 'description')
props.project_url = ask("Define value for 'url': ", '', 'url')
props.project_scm = ask("Define value for 'scm': ", '', 'scm')
props.project_issues = ask("Define value for 'issues': ", '', 'issues')
props.project_bintray_repo = ask("Define value for 'bintray repo': ", '', 'bintray_repo')
props.project_bintray_org = ask("Define value for 'bintray org': ", '', 'bintray_org')

processTemplates 'gradle.properties', props
