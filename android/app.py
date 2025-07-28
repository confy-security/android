from kivy.lang import Builder
from kivymd.app import MDApp


class ConfyApp(MDApp):
    def build(self):
        self.theme_cls.theme_style = 'Dark'
        return Builder.load_file('android/screens.kv')
