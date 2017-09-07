let gulp = require('gulp');
let clean = require('gulp-clean');

gulp.task("clean-dist", function() {
  return gulp.src('dist/', {read: false})
    .pipe(clean());
});

gulp.task("copy", function() {
  return gulp.src(['index.html', 'images/**', 'scripts/**', 'config/**', 'styles/**'], {base: "."})
    .pipe(gulp.dest('dist/'));
});

gulp.task("dist", gulp.series(['clean-dist', 'copy']));

