from kivymd.tools.hotreload.app import MDApp
from kivy.lang import Builder
from kivy.utils import hex_colormap


class HotReload(MDApp):
    KV_FILES = ['android/screens.kv']
    DEBUG = True
    
    def build_app(self):
        self.theme_cls.theme_style = "Dark"
        # self.theme_cls.primary_palette = "Blue"
        return Builder.load_file('android/screens.kv')
    

HotReload().run()
