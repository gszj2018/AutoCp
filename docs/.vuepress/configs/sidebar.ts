import type {SidebarConfig} from '@vuepress/theme-default'

export const sidebarConfig: SidebarConfig = {
    '/guide/': [
        {
            text: "Guide",
            children: [
                '/guide/README.md',
                '/guide/getting-started.md',
                '/guide/usage.md',
                '/guide/file-templates.md',
                '/guide/commands.md',
            ]
        }
    ]
}