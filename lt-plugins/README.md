
Lighttable plugin list
======================

A small webapp for the **diving into clojurescript** workshop.

```
lein cljsbuild auto
```

Open lighttable and a browser tab, and connect to it to eval and play with the
code.

The different versions of the code are stored in `src-steps/`.

Library references:
https://github.com/holmsand/reagent
https://github.com/JulianBirch/cljs-ajax#getpost-examples


Steps
-----

### 1. Initial project

Look for project.clj. Compilation setup and dependencies.

**Web ouput is in `web/`**

`web/index.html` and a `web/style.css`

**Source is in src**
`src/lt_plugins/core.cljs`

**For live development:**

* In a terminal: `lein cljsbuild auto`
* In Lighttable:
  * ctrl-space -> Add browser tab
  * Put the full url of your index.html as in Chrome
    `file:///Users/jkn/dev/projects/diving-into-clojurescript/code/exercises/lt-plugins/web/index.html`
  * Go to `core.cljs`
  * cmd-enter on the `println`
  * When LT asks, choose the file url
  * Connected to a browser!!
  * Open the console (View -> Console) and see the println do its thing (shares browser tab console with LT console)

