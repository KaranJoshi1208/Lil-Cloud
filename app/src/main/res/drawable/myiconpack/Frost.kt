package myiconpack

import MyIconPack
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val MyIconPack.Frost: ImageVector
    get() {
        if (_frost != null) {
            return _frost!!
        }
        _frost = Builder(name = "Frost", defaultWidth = 56.0.dp, defaultHeight = 48.0.dp,
                viewportWidth = 56.0f, viewportHeight = 48.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(11.0f, 36.0f)
                lineTo(45.0f, 36.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.5f, 41.0f)
                lineTo(40.5f, 41.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(22.5f, 46.0f)
                lineTo(33.5f, 46.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(28.0f, 33.0f)
                lineTo(28.0f, 11.0f)
                moveTo(28.0f, 24.0f)
                lineToRelative(11.0f, -3.67f)
                moveTo(34.0f, 22.0f)
                lineToRelative(2.0f, -4.0f)
                moveTo(34.0f, 22.0f)
                lineToRelative(4.0f, 2.0f)
                moveTo(28.0f, 24.0f)
                lineToRelative(-11.0f, -3.67f)
                moveTo(22.0f, 22.0f)
                lineToRelative(-2.0f, -4.0f)
                moveTo(22.0f, 22.0f)
                lineToRelative(-4.0f, 2.0f)
                moveTo(28.0f, 16.27f)
                lineToRelative(3.01f, -3.02f)
                moveTo(28.0f, 16.27f)
                lineToRelative(-3.01f, -3.02f)
            }
        }
        .build()
        return _frost!!
    }

private var _frost: ImageVector? = null
