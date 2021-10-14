import type {SidebarConfig} from '@vuepress/theme-default'

export const sidebarConfig: SidebarConfig = {
    '/guide/': [
        {
            text: "Guide",
            children: [
                '/guide/README.md',
                '/guide/getting-started.md'
            ]
        }
    ]
}